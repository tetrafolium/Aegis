package com.beemdevelopment.aegis.ui.glide;

import androidx.annotation.NonNull;

import com.beemdevelopment.aegis.db.DatabaseEntry;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;

import java.nio.ByteBuffer;

public class IconLoader implements ModelLoader<DatabaseEntry, ByteBuffer> {
    @Override
    public LoadData<ByteBuffer> buildLoadData(final @NonNull DatabaseEntry model, final int width, final int height, final @NonNull Options options) {
        return new LoadData<>(new UUIDKey(model.getUUID()), new Fetcher(model));
    }

    @Override
    public boolean handles(final @NonNull DatabaseEntry model) {
        return true;
    }

    public static class Fetcher implements DataFetcher<ByteBuffer> {
        private DatabaseEntry _model;

        private Fetcher(final DatabaseEntry model) {
            _model = model;
        }

        @Override
        public void loadData(final @NonNull Priority priority, final @NonNull DataCallback<? super ByteBuffer> callback) {
            byte[] bytes = _model.getIcon();
            ByteBuffer buf = ByteBuffer.wrap(bytes);
            callback.onDataReady(buf);
        }

        @Override
        public void cleanup() {

        }

        @Override
        public void cancel() {

        }

        @NonNull
        @Override
        public Class<ByteBuffer> getDataClass() {
            return ByteBuffer.class;
        }

        @NonNull
        @Override
        public DataSource getDataSource() {
            return DataSource.MEMORY_CACHE;
        }
    }

    public static class Factory implements ModelLoaderFactory<DatabaseEntry, ByteBuffer> {
        @NonNull
        @Override
        public ModelLoader<DatabaseEntry, ByteBuffer> build(final @NonNull MultiModelLoaderFactory unused) {
            return new IconLoader();
        }

        @Override
        public void teardown() {

        }
    }
}
