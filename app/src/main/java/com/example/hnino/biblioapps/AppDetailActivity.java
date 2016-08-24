package com.example.hnino.biblioapps;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hnino.biblioapps.business.AppBusiness;
import com.example.hnino.biblioapps.greendao.App;
import com.example.hnino.biblioapps.util.Constant;

public class AppDetailActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener{


    /**
     * Whether or not we're showing the back of the card (otherwise showing the front).
     */
    private boolean mShowingBack = false;
    private Fragment mFragment;
    private Bundle args;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_flip);
        Long idApp = getIntent().getLongExtra(Constant.ID_APP, new Long(1));
        AppBusiness appBusiness = new AppBusiness(getApplicationContext());
        App app = appBusiness.getAppById(idApp);
        args = new Bundle();
        args.putString(Constant.TITLE, app.getName());
        args.putString(Constant.SUMMARY, app.getSummary());
        args.putString(Constant.RELEASE_DATE, app.getReleaseDate());
        if (savedInstanceState == null) {
            // If there is no saved instance state, add a fragment representing the
            // front of the card to this activity. If there is saved instance state,
            // this fragment will have already been added to the activity.
            mFragment = new CardFrontFragment();
            mFragment.setArguments(args);
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, mFragment)
                    .commit();
        } else {
            mShowingBack = (getFragmentManager().getBackStackEntryCount() > 0);
        }

        // Monitor back stack changes to ensure the action bar shows the appropriate
        // button (either "photo" or "info").
        getFragmentManager().addOnBackStackChangedListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_app_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_flip:
                flipCard();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.rotate, R.anim.slide_out_left);
    }

    private void flipCard() {
        if (mShowingBack) {
            getFragmentManager().popBackStack();
            return;
        }

        // Flip to the back.

        mShowingBack = true;

        // Create and commit a new fragment transaction that adds the fragment for the back of
        // the card, uses custom animations, and is part of the fragment manager's back stack.
        mFragment = new CardBackFragment();
        mFragment.setArguments(args);
        getFragmentManager()
                .beginTransaction()

                // Replace the default fragment animations with animator resources representing
                // rotations when switching to the back of the card, as well as animator
                // resources representing rotations when flipping back to the front (e.g. when
                // the system Back button is pressed).
                .setCustomAnimations(
                        R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in, R.animator.card_flip_left_out)

                // Replace any fragments currently in the container view with a fragment
                // representing the next page (indicated by the just-incremented currentPage
                // variable).
                .replace(R.id.container, mFragment)

                // Add this transaction to the back stack, allowing users to press Back
                // to get to the front of the card.
                .addToBackStack(null)

                // Commit the transaction.
                .commit();


    }

    @Override
    public void onBackStackChanged() {
        mShowingBack = (getFragmentManager().getBackStackEntryCount() > 0);

        // When the back stack changes, invalidate the options menu (action bar).
        invalidateOptionsMenu();
    }

    /**
     * A fragment representing the front of the card.
     */
    public static class CardFrontFragment extends Fragment {
        public CardFrontFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_card_front, container, false);
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {

            TextView tvDetail = (TextView) view.findViewById(R.id.tvDetail);
            TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);


            tvDetail.setText(getArguments().getString(Constant.SUMMARY));
            tvDetail.setMovementMethod(new ScrollingMovementMethod());
            tvTitle.setText(getArguments().getString(Constant.TITLE));
        }
    }

    /**
     * A fragment representing the back of the card.
     */
    public static class CardBackFragment extends Fragment {
        public CardBackFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_card_back, container, false);
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            TextView tvReleaseDate = (TextView) view.findViewById(R.id.tvReleaseDate);

            tvTitle.setText(getArguments().getString(Constant.TITLE));
            tvReleaseDate.setText(getArguments().getString(Constant.RELEASE_DATE));

        }
    }
}
