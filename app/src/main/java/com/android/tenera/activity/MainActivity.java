package com.android.tenera.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tenera.R;
import com.android.tenera.application.MainApplication;
import com.android.tenera.fragments.CartFragment;

import com.shopify.buy.model.Cart;
import com.shopify.buy.model.Checkout;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolBar;
    private NavigationView navigationView;
    private ImageView mImageHome;
    private TextView mTextHome;
    private ImageView mImageExploreCategories;
    private TextView mTextExploreCategories;
    private ImageView mImageCart;
    private TextView mTextCart;
    private ImageView mImagePromotionalOffer;
    private TextView mTextPromotionalOffer;
    private ImageView mImageInviteFriend;
    private TextView mTextInviteFriend;
    private ImageView mImageAbout;
    private TextView mTextAbout;
    private ImageView mImageSupport;
    private TextView mTextSupport;
    private ImageView mNavHome;
    private ImageView mNavExploreCategories;
    private ImageView mNavCart;
    private ImageView mNavPromotionalOffer;
    private ImageView mNavInviteFriend;
    private ImageView mNavAbout;
    private ImageView mNavSupport;
    private DrawerLayout drawerLayout;
    private RelativeLayout progressLayout;


    public static MainActivity getInstance() {
        return instance;
    }

    public static void setInstance(MainActivity instance) {
        MainActivity.instance = instance;
    }

    private static MainActivity instance;


    private TextView mPreviousSelectedDrawerText;
    private ImageView mPreviousSelectedDrawerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolBar = (Toolbar) findViewById(R.id.custom_toolbar);
        setSupportActionBar(mToolBar);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        progressLayout = (RelativeLayout) findViewById(R.id.progressLayout);
        mImageHome = (ImageView) navigationView.findViewById(R.id.image_home);
        mTextHome = (TextView) navigationView.findViewById(R.id.text_home);
        mImageExploreCategories = (ImageView) navigationView.findViewById(R.id.image_explore_categories);
        mTextExploreCategories = (TextView) navigationView.findViewById(R.id.text_explore_categories);
        mImageCart = (ImageView) navigationView.findViewById(R.id.image_cart);
        mTextCart = (TextView) navigationView.findViewById(R.id.text_cart);
        mImagePromotionalOffer = (ImageView) navigationView.findViewById(R.id.image_promotional_offers);
        mTextPromotionalOffer = (TextView) navigationView.findViewById(R.id.text_promotional_offer);
        mImageInviteFriend = (ImageView) navigationView.findViewById(R.id.image_inivite_friend);
        mTextInviteFriend = (TextView) navigationView.findViewById(R.id.text_invite_friend);
        mImageAbout = (ImageView) navigationView.findViewById(R.id.image_about);
        mTextAbout = (TextView) navigationView.findViewById(R.id.text_about);
        mImageSupport = (ImageView) navigationView.findViewById(R.id.image_support);
        mTextSupport = (TextView) navigationView.findViewById(R.id.text_support);
        mNavHome = (ImageView) navigationView.findViewById(R.id.nav_home);
        mNavExploreCategories = (ImageView) navigationView.findViewById(R.id.nav_explore_categories);
        mNavCart = (ImageView) navigationView.findViewById(R.id.nav_cart);
        mNavPromotionalOffer = (ImageView) navigationView.findViewById(R.id.nav_promotional_offer);
        mNavInviteFriend = (ImageView) navigationView.findViewById(R.id.nav_invite_friend);
        mNavAbout = (ImageView) navigationView.findViewById(R.id.nav_about);
        mNavSupport = (ImageView) navigationView.findViewById(R.id.nav_support);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavHome.setOnClickListener(this);
        mNavExploreCategories.setOnClickListener(this);
        mNavCart.setOnClickListener(this);
        mNavPromotionalOffer.setOnClickListener(this);
        mNavInviteFriend.setOnClickListener(this);
        mNavAbout.setOnClickListener(this);
        mNavSupport.setOnClickListener(this);
        setInstance(this);
        if (savedInstanceState == null) {
            loadHomeFragment();
        }

    }

    public void showLoader() {
        progressLayout.setVisibility(View.VISIBLE);
    }

    public void hideLoader() {
        progressLayout.setVisibility(View.GONE);
    }

    private void loadHomeFragment() {
        getSupportFragmentManager().beginTransaction().add(R.id.container, new HomeFragment()).commit();
    }

    private void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
    }

    private void addFragmentWithBackStack(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).addToBackStack(fragment.getTag()).commit();
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    public void replaceFragmentWithBackStack(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(fragment.getTag()).commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nav_home:
                loadHomeFragment();
                if (isPreviousPresent()) {
                    mPreviousSelectedDrawerText.setTextColor(getResources().getColor(R.color.color_de2d2d2d));
                    mPreviousSelectedDrawerImage.setSelected(false);
                }
                mImageHome.setSelected(true);
                mTextHome.setTextColor(getResources().getColor(R.color.color_ffbf00));
                mPreviousSelectedDrawerImage = mImageHome;
                mPreviousSelectedDrawerText = mTextHome;
                closeDrawer();
                break;
            case R.id.nav_explore_categories:
                if (isPreviousPresent()) {
                    mPreviousSelectedDrawerText.setTextColor(getResources().getColor(R.color.color_de2d2d2d));
                    mPreviousSelectedDrawerImage.setSelected(false);
                }
                mImageExploreCategories.setSelected(true);
                mTextExploreCategories.setTextColor(getResources().getColor(R.color.color_ffbf00));
                mPreviousSelectedDrawerImage = mImageExploreCategories;
                mPreviousSelectedDrawerText = mTextExploreCategories;
                closeDrawer();
                break;
            case R.id.nav_cart:
                CartFragment cartFragment = new CartFragment();
                replaceFragmentWithBackStack(cartFragment);
                if (isPreviousPresent()) {
                    mPreviousSelectedDrawerText.setTextColor(getResources().getColor(R.color.color_de2d2d2d));
                    mPreviousSelectedDrawerImage.setSelected(false);
                }
                mImageCart.setSelected(true);
                mTextCart.setTextColor(getResources().getColor(R.color.color_ffbf00));
                mPreviousSelectedDrawerImage = mImageCart;
                mPreviousSelectedDrawerText = mTextCart;
                closeDrawer();
                break;
            case R.id.nav_promotional_offer:
                loadHomeFragment();
                if (isPreviousPresent()) {
                    mPreviousSelectedDrawerText.setTextColor(getResources().getColor(R.color.color_de2d2d2d));
                    mPreviousSelectedDrawerImage.setSelected(false);
                }
                mImagePromotionalOffer.setSelected(true);
                mTextPromotionalOffer.setTextColor(getResources().getColor(R.color.color_ffbf00));
                mPreviousSelectedDrawerImage = mImagePromotionalOffer;
                mPreviousSelectedDrawerText = mTextPromotionalOffer;
                closeDrawer();
                break;
            case R.id.nav_invite_friend:
                loadHomeFragment();
                if (isPreviousPresent()) {
                    mPreviousSelectedDrawerText.setTextColor(getResources().getColor(R.color.color_de2d2d2d));
                    mPreviousSelectedDrawerImage.setSelected(false);
                }
                mImageInviteFriend.setSelected(true);
                mTextInviteFriend.setTextColor(getResources().getColor(R.color.color_ffbf00));
                mPreviousSelectedDrawerImage = mImageInviteFriend;
                mPreviousSelectedDrawerText = mTextInviteFriend;
                closeDrawer();
                break;
            case R.id.nav_about:
                loadHomeFragment();
                if (isPreviousPresent()) {
                    mPreviousSelectedDrawerText.setTextColor(getResources().getColor(R.color.color_de2d2d2d));
                    mPreviousSelectedDrawerImage.setSelected(false);
                }
                mImageAbout.setSelected(true);
                mTextAbout.setTextColor(getResources().getColor(R.color.color_ffbf00));
                mPreviousSelectedDrawerImage = mImageAbout;
                mPreviousSelectedDrawerText = mTextAbout;
                closeDrawer();
                break;
            case R.id.nav_support:
                loadHomeFragment();
                if (isPreviousPresent()) {
                    mPreviousSelectedDrawerText.setTextColor(getResources().getColor(R.color.color_de2d2d2d));
                    mPreviousSelectedDrawerImage.setSelected(false);
                }
                mImageSupport.setSelected(true);
                mTextSupport.setTextColor(getResources().getColor(R.color.color_ffbf00));
                mPreviousSelectedDrawerImage = mImageSupport;
                mPreviousSelectedDrawerText = mTextSupport;
                closeDrawer();
                break;
            default:
                break;
        }
    }

    /*
    * @param errorMessage
    */
    public void onError(String errorMessage) {
        hideLoader();
        Log.e("Error: ", " " + errorMessage);
        Toast.makeText(this, "Error: ", Toast.LENGTH_LONG).show();
        finish();
    }

    public boolean isPreviousPresent() {
        if (mPreviousSelectedDrawerImage == null && mPreviousSelectedDrawerText == null) {
            return false;
        } else {
            return true;
        }
    }

    public MainApplication getMainApplication() {
        return (MainApplication) getApplication();
    }

    public void closeDrawer() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
    }
}
