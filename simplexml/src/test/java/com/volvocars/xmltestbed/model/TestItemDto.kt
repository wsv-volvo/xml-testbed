package com.volvocars.xmltestbed.model

import org.simpleframework.xml.Attribute

data class TestItemDto
@JvmOverloads constructor(
    @field:Attribute var id: String = "",
    @field:Attribute var value: Int = 0
)
