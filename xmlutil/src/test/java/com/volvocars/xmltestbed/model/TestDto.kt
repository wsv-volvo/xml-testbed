package com.volvocars.xmltestbed.model

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlChildrenName
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName
import nl.adaptivity.xmlutil.serialization.XmlValue

/*
 * Document root node
 * Basic element of string type
 * Nested object
 * List of objects
 */
@Serializable
@XmlSerialName("test")
data class TestDto(
    @XmlElement val title: String,
    @XmlSerialName("detail") val detail: TestDetailDto?,
    @XmlSerialName("items") @XmlChildrenName("item") val items: List<TestItemDto>? = null
)
