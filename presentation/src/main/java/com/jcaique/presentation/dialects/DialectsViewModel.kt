package com.jcaique.presentation.dialects

import com.jcaique.domain.dialects.DialectsService
import com.jcaique.domain.models.Dialect
import com.jcaique.utils.dataflow.StateMachine
import com.jcaique.utils.dataflow.StateTransition
import com.jcaique.utils.dataflow.UnsupportedUserInteraction
import com.jcaique.utils.dataflow.UserInteraction
import kotlinx.coroutines.coroutineScope

internal class DialectsViewModel(
    private val machine: StateMachine<DialectsPresentation>,
    private val service: DialectsService
) {

    private var dialects = emptyList<Dialect>()

    fun bind() = machine.states()

    fun handle(interaction: UserInteraction) {
        interpret(interaction)
            .let(machine::consume)
    }

    private fun interpret(interaction: UserInteraction) =
        when (interaction) {
            is ShowDialects -> StateTransition(::showDialects, interaction)
            is FilterDialects -> StateTransition(::filterDialects, interaction)
            else -> throw UnsupportedUserInteraction
        }

    // TODO get dialects from service
    private suspend fun showDialects(
        parameters: StateTransition.Parameters
    ): DialectsPresentation = coroutineScope {
        val interaction = parameters as ShowDialects

        dialects = service.getDialectsBy(interaction.region.name.toLowerCase())

        dialects
            .let(::DialectsPresentation)
    }
        
    private suspend fun filterDialects(
        parameters: StateTransition.Parameters
    ): DialectsPresentation = coroutineScope {
        val interaction = parameters as FilterDialects
        
        dialects
            .filter { it.dialect.contains(interaction.query, ignoreCase = true) }
            .let(::DialectsPresentation)
    }
}
