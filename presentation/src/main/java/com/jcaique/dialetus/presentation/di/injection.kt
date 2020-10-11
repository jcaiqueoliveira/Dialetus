package com.jcaique.dialetus.presentation.di

import com.jcaique.dialetus.presentation.dialects.DialectsViewModel
import com.jcaique.dialetus.presentation.regions.RegionsViewModel
import com.jcaique.dialetus.utils.KodeinTags
import com.jcaique.dialetus.utils.extensions.newStateContainer
import com.jcaique.dialetus.utils.extensions.newStateMachine
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val presentationModule = DI.Module(name = "presentation") {

    bind() from provider {
        RegionsViewModel(
            service = instance()
        )
    }

    bind() from provider {
        DialectsViewModel(
            service = instance()
        )
    }
}
