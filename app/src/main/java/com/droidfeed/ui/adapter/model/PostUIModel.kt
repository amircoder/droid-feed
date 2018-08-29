package com.droidfeed.ui.adapter.model

import android.view.LayoutInflater
import android.view.ViewGroup
import com.droidfeed.data.model.Post
import com.droidfeed.databinding.ListItemPostLargeBinding
import com.droidfeed.databinding.ListItemPostSmallBinding
import com.droidfeed.ui.adapter.UiModelType
import com.droidfeed.ui.adapter.diff.Diffable
import com.droidfeed.ui.adapter.viewholder.PostLargeViewHolder
import com.droidfeed.ui.adapter.viewholder.PostSmallViewHolder
import com.droidfeed.ui.adapter.viewholder.PostViewHolder
import com.droidfeed.ui.common.BaseUiModel
import com.droidfeed.ui.module.feed.ArticleClickListener

data class PostUIModel(
    private val post: Post,
    private val onRssClickListener: ArticleClickListener
) : BaseUiModel<PostViewHolder>() {

    override fun getViewHolder(parent: ViewGroup): PostViewHolder =
        when (post.layoutType) {
            UiModelType.POST_SMALL -> PostSmallViewHolder(
                ListItemPostSmallBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> PostLargeViewHolder(
                ListItemPostLargeBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

    override fun bindViewHolder(viewHolder: PostViewHolder) {
        viewHolder.bind(post, onRssClickListener)
    }

    override fun getViewType(): Int = post.layoutType.ordinal

    override fun getData(): Diffable = post
}