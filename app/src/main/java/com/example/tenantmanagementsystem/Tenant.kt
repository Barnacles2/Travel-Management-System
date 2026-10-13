package com.example.tenantmanagementsystem

// Serializable is built into Java/Kotlin: no plugin needed
import java.io.Serializable

// a Tenant can be packed up and sent to another screen , serialization
data class Tenant(
    val name: String,
    val phone: String,
    val rent: String
) : Serializable {

    // The text shown on screen
    fun summary(): String {
        return "Tenant: $name\nPhone: $phone\nRent: KSh $rent"
    }
}