package com.geomslayer.tchat

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_chat_message.view.*

class ChatAdapter(private val dataset: List<MessageItem>,
                    private val clickListener: OnItemClickListener) :
        RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindDialog(dataset[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_chat_message, parent, false)
        return ViewHolder(view, clickListener)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    class ViewHolder(view: View, val listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {

        init {
            itemView.setOnClickListener { listener.onItemClick(adapterPosition) }
        }

        fun bindDialog(messageItem: MessageItem) {
            itemView.authorTextView.text = messageItem.author // TODO
            itemView.messageTextView.text = messageItem.message
        }
    }
}