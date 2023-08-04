package com.volvocars.xmltestbed.model

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

/*
 * Object with attribute and elements
 * Basic elements of various types
 * Elements with custom names
 */
@Serializable
data class TestDetailDto(
    val id: String,
    @XmlElement val bool: Boolean? = null,
    @XmlElement @XmlSerialName("int") val intNumber: Int? = null,
    @XmlElement @XmlSerialName("float") val floatNumber: Float? = null,
    @XmlElement @XmlSerialName("enum") val enumValue: TestEnum? = null
)
