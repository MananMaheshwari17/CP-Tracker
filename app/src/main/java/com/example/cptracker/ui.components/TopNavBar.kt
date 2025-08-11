package com.example.cptracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cptracker.R
import com.example.cptracker.ui.theme.navBarGradient

data class NavItem(
    val label: String,
    val iconRes: Int
)

@Composable
fun TopNavBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    onThemeToggle: () -> Unit
) {
    val navItems = listOf(
        NavItem("User", R.drawable.mdi_user),
        NavItem("Friends", R.drawable.mdi_users),
        NavItem("Analyzer", R.drawable.majesticons_robot),
        NavItem("Leaderboard", R.drawable.material_symbols_leaderboard_rounded)
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(brush = navBarGradient())
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // User (far left)
        val selectedUser = selectedIndex == 0
        val userContentColor = if (selectedUser) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onBackground
        Column(
            modifier = Modifier
                .clickable { onItemSelected(0) },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = navItems[0].iconRes),
                contentDescription = navItems[0].label,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = navItems[0].label,
                color = Color.Black,
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center
            )
        }

        // Middle items container (takes max space between user & theme)
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            navItems.subList(1, navItems.size).forEachIndexed { index, item ->
                val realIndex = index + 1
                val selected = selectedIndex == realIndex
                val contentColor = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onBackground

                Column(
                    modifier = Modifier
                        .clickable { onItemSelected(realIndex) },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = item.iconRes),
                        contentDescription = item.label,
                        modifier = Modifier.size(28.dp),
                        tint = contentColor
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = item.label,
                        color = contentColor,
                        style = MaterialTheme.typography.titleSmall,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        // Theme toggle (far right)
        val themeContentColor = MaterialTheme.colorScheme.onPrimary
        Column(
            modifier = Modifier
                .clickable { onThemeToggle() },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.proicons_dark_theme),
                contentDescription = "Toggle Theme",
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Theme",
                color = Color.Black,
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun TopNavBarPreview() {
    MaterialTheme {
        Surface {
            var selectedIndex by remember { mutableStateOf(0) }
            TopNavBar(
                selectedIndex = selectedIndex,
                onItemSelected = { selectedIndex = it },
                onThemeToggle = { /* no-op for preview */ }
            )
        }
    }
}
