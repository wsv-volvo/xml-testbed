package com.volvocars.xmltestbed.model

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlSerialName

/*
 * Object with only attributes
 */
@Serializable
data class TestItemDto(
    val id: String,
    val value: Int
)
