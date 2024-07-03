package io.github.droidkaigi.confsched.sessions.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import conference_app_2024.feature.sessions.generated.resources.Res
import conference_app_2024.feature.sessions.generated.resources.calendar_add_on
import io.github.droidkaigi.confsched.designsystem.preview.MultiLanguagePreviews
import io.github.droidkaigi.confsched.designsystem.preview.MultiThemePreviews
import io.github.droidkaigi.confsched.designsystem.theme.KaigiTheme
import io.github.droidkaigi.confsched.model.TimetableItem
import io.github.droidkaigi.confsched.model.fake
import io.github.droidkaigi.confsched.sessions.TimetableItemDetailBookmarkIconTestTag
import org.jetbrains.compose.resources.painterResource

@Composable
fun TimetableItemDetailBottomAppBar(
    timetableItem: TimetableItem,
    isBookmarked: Boolean,
    onBookmarkClick: (TimetableItem) -> Unit,
    onCalendarRegistrationClick: (TimetableItem) -> Unit,
    modifier: Modifier = Modifier,
    onShareClick: (TimetableItem) -> Unit,
) {
    BottomAppBar(
        modifier = modifier,
        actions = {
            IconButton(onClick = { onShareClick(timetableItem) }) {
                Icon(
                    imageVector = Icons.Outlined.Share,
                    contentDescription = "Share",
                )
            }
            IconButton(onClick = { onCalendarRegistrationClick(timetableItem) }) {
                Icon(
                    painter = painterResource(Res.drawable.calendar_add_on),
                    contentDescription = "Calendar",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.testTag(TimetableItemDetailBookmarkIconTestTag),
                onClick = { onBookmarkClick(timetableItem) },
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
            ) {
                Icon(
                    imageVector = if (isBookmarked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "Bookmarked",
                )
            }
        },
    )
}

@Composable
@MultiThemePreviews
@MultiLanguagePreviews
fun TimetableItemDetailBottomAppBarPreview() {
    KaigiTheme {
        Surface {
            TimetableItemDetailBottomAppBar(
                timetableItem = TimetableItem.Session.fake(),
                isBookmarked = false,
                onBookmarkClick = {},
                onCalendarRegistrationClick = {},
                onShareClick = {},
            )
        }
    }
}

@Composable
@MultiThemePreviews
@MultiLanguagePreviews
fun TimetableItemDetailBottomAppBarBookmarkedPreview() {
    KaigiTheme {
        Surface {
            TimetableItemDetailBottomAppBar(
                timetableItem = TimetableItem.Session.fake(),
                isBookmarked = true,
                onBookmarkClick = {},
                onCalendarRegistrationClick = {},
                onShareClick = {},
            )
        }
    }
}