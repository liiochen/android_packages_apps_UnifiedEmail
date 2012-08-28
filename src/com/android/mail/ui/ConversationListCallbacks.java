/*
 * Copyright (C) 2012 Google Inc.
 * Licensed to The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.mail.ui;

import android.app.LoaderManager.LoaderCallbacks;
import android.database.DataSetObserver;

import com.android.mail.browse.ConversationCursor;
import com.android.mail.providers.Conversation;

/**
 * A controller interface that is to receive user initiated events and handle them.
 */
public interface ConversationListCallbacks {
    /**
     * Show the conversation provided here. If the conversation is null, this is a request to pop
     * <em>out</em> of conversation view mode and head back to conversation list mode, or whatever
     * should best show in its place.
     * @param conversation conversation to display, possibly null.
     * @param inLoaderCallbacks whether we are in the scope of a {@link LoaderCallbacks} method
     * (when fragment transactions are disallowed)
     */
    void onConversationSelected(Conversation conversation, boolean inLoaderCallbacks);

    ConversationCursor getConversationListCursor();

    Conversation getCurrentConversation();
    void setCurrentConversation(Conversation c);

    void registerConversationListObserver(DataSetObserver observer);
    void unregisterConversationListObserver(DataSetObserver observer);
}
