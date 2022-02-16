package com.rakibstudiohindicartoontv.quatar.adapter

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityManager
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.rakibstudiohindicartoontv.quatar.R
import com.rakibstudiohindicartoontv.quatar.databinding.ItemArticlePreviewBinding
import com.rakibstudiohindicartoontv.quatar.model2.Article


class NewsAdapter :  RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(val binding: ItemArticlePreviewBinding) :
        RecyclerView.ViewHolder(binding.root)


    private val differCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {

        val binding =
            ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return differ.currentList.size

    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList.get(position)
        holder.binding.apply {
//            Glide.with(this).load(article.urlToImage).into(bindind.ivArticleImage)
//try {
//    article
//
//}catch (e: Exception){
//
//}
//            if (article.urlToImage ==null){
//
//                Glide.with(Activity()).load(R.drawable.ic_launcher_background).into(ivArticleImage)
//
//                tvSource.text = article.source?.name
//                tvTitle.text = article.title
//                tvDescription.text = article.description
//                tvPublishedAt.text = article.publishedAt
//            }else{

                Toast.makeText(Activity(),article.urlToImage, Toast.LENGTH_LONG).show()


           textViewsp.text=article.urlToImage
//                Toast.makeText(Activity(), "Sin conexión a Internet...", Toast.LENGTH_SHORT).show();
                tvSource.text = article.source?.name
                tvTitle.text = article.title
                tvDescription.text = article.description
                tvPublishedAt.text = article.publishedAt
//            }

        }
    }
}