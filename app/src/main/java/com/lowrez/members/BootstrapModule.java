package com.lowrez.members;

import android.accounts.AccountManager;
import android.content.Context;

import com.lowrez.members.authenticator.BootstrapAuthenticatorActivity;
import com.lowrez.members.authenticator.LogoutService;
import com.lowrez.members.core.CheckIn;
import com.lowrez.members.core.TimerService;
import com.lowrez.members.ui.BootstrapTimerActivity;
import com.lowrez.members.ui.CarouselActivity;
import com.lowrez.members.ui.CheckInsListFragment;
import com.lowrez.members.ui.ItemListFragment;
import com.lowrez.members.ui.NewsActivity;
import com.lowrez.members.ui.NewsListFragment;
import com.lowrez.members.ui.UserActivity;
import com.lowrez.members.ui.UserListFragment;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for setting up provides statements.
 * Register all of your entry points below.
 */
@Module
(
        complete = false,

        injects = {
                BootstrapApplication.class,
                BootstrapAuthenticatorActivity.class,
                CarouselActivity.class,
                BootstrapTimerActivity.class,
                CheckInsListFragment.class,
                NewsActivity.class,
                NewsListFragment.class,
                UserActivity.class,
                UserListFragment.class,
                TimerService.class
        }

)
public class BootstrapModule  {

    @Singleton
    @Provides
    Bus provideOttoBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    LogoutService provideLogoutService(final Context context, final AccountManager accountManager) {
        return new LogoutService(context, accountManager);
    }

}
