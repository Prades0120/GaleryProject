package com.example.galeryproject.ui.gallery

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.galeryproject.CardsAdapter
import com.example.galeryproject.R
import com.example.galeryproject.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel
    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView: RecyclerView = binding.recyclerView
        galleryViewModel.content.observe(viewLifecycleOwner, {
            val adapter = CardsAdapter(it)
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            val modeCallBack: ActionMode.Callback = object : ActionMode.Callback {
                override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                    when (item?.itemId) {
                        R.id.action_editar -> {
                            Log.i("MainActivity", "editar")
                            mode?.finish()
                        }
                        R.id.action_eliminar -> {
                            Log.i("MainActivity", "eliminar")
                            mode?.finish()
                        }
                        R.id.action_compartir -> {
                            Log.i("MainActivity", "compartir")
                            mode?.finish()
                        }
                        else -> return false
                    }
                    return true
                }

                override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
                    return false
                }

                override fun onDestroyActionMode(mode: ActionMode?) {
                    var mode = mode
                    mode = null
                }

                override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
                    mode.title = "Options"
                    mode.menuInflater.inflate(R.menu.menu_context, menu)
                    return true
                }
            }

            adapter.onLongClick = { view ->
                view.startActionMode(modeCallBack)
            }
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}