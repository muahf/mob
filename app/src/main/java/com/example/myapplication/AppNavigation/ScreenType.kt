package com.example.myapplication.AppNavigation

import com.example.myapplication.R

sealed class ScreenType {
    object WithoutBottomNav : ScreenType()
    object WithBottomNav : ScreenType()
}

sealed class Screen(val route: String, val screenType: ScreenType) {
    object Home : Screen(route = "home", screenType = ScreenType.WithBottomNav)
    object Details : Screen(route = "details", screenType = ScreenType.WithoutBottomNav)
    object Calendar : Screen(route = "calendar", screenType = ScreenType.WithBottomNav)
    object Search : Screen(route = "search", screenType = ScreenType.WithBottomNav)
    object Messages : Screen(route = "messages", screenType = ScreenType.WithBottomNav)
    object Profile : Screen(route = "profile", screenType = ScreenType.WithBottomNav)
    object Splash : Screen(route = "splash", screenType = ScreenType.WithoutBottomNav)

    companion object {
        fun fromRoute(route: String?): Screen? = when (route) {
            Home.route -> Home
            Details.route -> Details
            Calendar.route -> Calendar
            Search.route -> Search
            Messages.route -> Messages
            Profile.route -> Profile
            Splash.route -> Splash
            else -> null
        }
    }
}

sealed class NavItem(val title: String, val screen: Screen, val iconRes: Int) {
    // Тут меняются иконки из app/src/main/res/drawable
    object Home : NavItem("Home", Screen.Home, R.drawable.home)
    object Calendar : NavItem("Calendar", Screen.Calendar, R.drawable.calendar)
    object Search : NavItem("Search", Screen.Search, R.drawable.poisk)
    object Messages : NavItem("Messages", Screen.Messages, R.drawable.caht)
    object Profile : NavItem("Profile", Screen.Profile, R.drawable.profile)
}