package com.google.android.settings.fuelgauge.batterysaver

import android.content.Context
import androidx.preference.Preference
import com.android.settings.R as AR
import com.android.settingslib.metadata.PreferenceMetadata
import com.android.settingslib.metadata.UI_ONLY_PREFERENCE
import com.android.settingslib.preference.PreferenceBinding
import com.android.settingslib.widget.IllustrationPreference
import com.google.android.settings.R

class AdaptiveBatteryIllustrationPreference : PreferenceMetadata, PreferenceBinding {

    override val key: String
        get() = "adaptive_battery_illustration"

    override val purpose: Int
        get() = R.string.adaptive_battery_illustration_purpose

    override val indexable: Boolean
        get() = false

    override fun tags(context: Context): Array<String> = arrayOf(UI_ONLY_PREFERENCE)

    override fun createWidget(context: Context): IllustrationPreference =
        IllustrationPreference(context).apply {
            // SettingsGoogle bundles its own R.raw.lottie_adaptive_battery,
            // but we reuse AOSP's Lottie to avoid duplicating raw assets.
            setLottieAnimationResId(AR.raw.auto_awesome_battery_expressive_lottie)
            applyDynamicColor()
        }

    override fun bind(preference: Preference, metadata: PreferenceMetadata) {
        super.bind(preference, metadata)
        preference.isSelectable = false
    }
}
