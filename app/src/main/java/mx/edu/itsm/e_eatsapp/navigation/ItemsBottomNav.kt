package mx.edu.itsm.e_eatsapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ItemsBottomNav(
    val route: String,
    val title: String,
    val icon: ImageVector
)