package com.example.tenantmanagementsystem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
// Generated from fragment_view_tenants.xml (a Data Binding layout)
import com.example.tenantmanagementsystem.databinding.FragmentViewTenantsBinding

class ViewTenantsFragment : Fragment() {

    private var _binding: FragmentViewTenantsBinding? = null
    private val binding get() = _binding!!

    // SAFE ARGS: reads the arguments that arrived with the action.
    // ViewTenantsFragmentArgs was generated from the <argument> in nav_graph.xml
    private val args: ViewTenantsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewTenantsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // The tenant sent from Add Tenant, or null if we came from the Dashboard
        val newTenant = args.newTenant

        // DATA BINDING: give it to <variable name="tenant"> in the layout.
        // newTenantTextView shows @{tenant.summary()}, so it updates itself
        binding.tenant = newTenant

        // No new tenant? Hide "Just added", the box and the Call button together
        if (newTenant == null) {
            binding.newTenantGroup.visibility = View.GONE
        }

        // Show every saved tenant as text, one after another
        val tenants = TenantRepository.tenants
        if (tenants.isEmpty()) {
            binding.allTenantsTextView.text = "No tenants yet. Add one from the Dashboard."
        } else {
            binding.allTenantsTextView.text = tenants.joinToString("\n\n") { it.summary() }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}