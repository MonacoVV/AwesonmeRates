package com.example.awesomerates.domain.state

data class MainScreenState(
    val title: String = "",
    val topBarVisible: Boolean = true,
    val drawerEnabled: Boolean = true,
    val bottomNavigationVisible: Boolean = true,
)
class MainScreenStateBuilder(
    base: MainScreenState = MainScreenState()
) {
    constructor(
        title: String,
        topBarVisible: Boolean,
        drawerEnabled: Boolean,
        bottomNavigationVisible: Boolean
    ) : this(
        MainScreenState(
            title = title,
            topBarVisible = topBarVisible,
            drawerEnabled = drawerEnabled,
            bottomNavigationVisible = bottomNavigationVisible
        )
    )

    var title: String = base.title
    var topBarVisible: Boolean = base.topBarVisible
    var drawerEnabled: Boolean = base.drawerEnabled
    var bottomNavigationVisible: Boolean = base.bottomNavigationVisible


    fun buildState(): MainScreenState {
        return MainScreenState(
            title = title,
            topBarVisible = topBarVisible,
            drawerEnabled = drawerEnabled,
            bottomNavigationVisible = bottomNavigationVisible
        )
    }
}

