package com.volvocars.xmltestbed.model

import org.simpleframework.xml.Attribute

/*
 * Object with only attributes
 */
data class TestItemDto
@JvmOverloads constructor(
    @field:Attribute var id: String = "",
    @field:Attribute var value: Int = 0
)
