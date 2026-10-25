package com.example.xcore.ui.feature.info

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.xcore.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Info(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(R.string.info_title),
                        style = MaterialTheme.typography.displaySmall
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding)
                    .verticalScroll(rememberScrollState())
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = stringResource(R.string.info_core_heading),
                style = MaterialTheme.typography.titleMedium,
            )

            ExpandableText(
                text = stringResource(R.string.info_core_overview)
            )

            HorizontalDivider()

            Text(
                text = stringResource(R.string.info_categories_heading),
                style = MaterialTheme.typography.titleMedium,
            )

            CoreCategory(
                title = stringResource(R.string.info_foundations_heading),
                description = stringResource(
                    R.string.info_foundations_description
                )
            )

            CoreCategory(
                title = stringResource(R.string.info_explorations_heading),
                description = stringResource(
                    R.string.info_explorations_description
                )
            )

            CoreCategory(
                title = stringResource(R.string.info_engagements_heading),
                description = stringResource(
                    R.string.info_engagements_description
                )
            )
        }
    }
}

@Composable
private fun CoreCategory(
    title: String,
    description: String
) {
    OutlinedCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
            )

            ExpandableText(text = description)
        }
    }
}

@Composable
private fun ExpandableText(text: String) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    var hasOverflow by remember(text) { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = if (expanded) Int.MAX_VALUE else 3,
            overflow = TextOverflow.Ellipsis,
            onTextLayout = { result ->
                if (!expanded) {
                    hasOverflow = result.hasVisualOverflow
                }
            }
        )

        if (expanded || hasOverflow) {
            TextButton(
                onClick = { expanded = !expanded }
            ) {
                Text(
                    text = stringResource(
                        if (expanded) R.string.show_less
                        else R.string.read_more
                    )
                )
            }
        }
    }
}