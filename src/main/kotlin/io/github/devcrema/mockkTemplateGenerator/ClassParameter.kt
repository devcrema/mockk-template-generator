package io.github.devcrema.mockkTemplateGenerator

import org.jetbrains.kotlin.types.KotlinType

data class ClassParameter (
    val name: String,
    val type: KotlinType,
)