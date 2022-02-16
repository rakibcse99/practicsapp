package com.rakibstudiohindicartoontv.quatar.adapter
import com.rakibstudiohindicartoontv.models.Result
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rakibstudiohindicartoontv.quatar.databinding.ItemRowBinding


class QuateAdapter :  RecyclerView.Adapter<QuateAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(val binding: ItemRowBinding) :
        RecyclerView.ViewHolder(binding.root)


    private val differCallback = object : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.author == newItem.author
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {

        val binding =
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return differ.currentList.size

    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList.get(position)
        holder.binding.apply {
//            Glide.with(this).load(article.urlToImage).into(bindind.ivArticleImage)

            tex1.text = article.author
            tex2.text = article.authorSlug
            tex3.text = article.content
            tex1.text = article.dateAdded

        }
    }
}