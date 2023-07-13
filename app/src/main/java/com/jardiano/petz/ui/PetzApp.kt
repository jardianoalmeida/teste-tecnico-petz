
package com.jardiano.petz.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.jardiano.petz.ui.navigation.AppNavigation

@Composable
fun PetzApp() {
    Surface {
        AppNavigation()
    }
}