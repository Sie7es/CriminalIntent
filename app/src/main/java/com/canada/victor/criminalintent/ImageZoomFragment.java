package com.canada.victor.criminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by victorcanadaojeda on 8/10/15.
 */
public class ImageZoomFragment extends DialogFragment {
    private static final String ARG_ZOOM = "arg_zoom";
    public static final String EXTRA_IMAGE_ZOOM = "com.canada.victor.criminalintent.imagezoomfragment";

    private ImageView mImageZoom;

    public static ImageZoomFragment newInstance(File file) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_ZOOM, file);

        ImageZoomFragment imageZoomFragment = new ImageZoomFragment();
        imageZoomFragment.setArguments(bundle);

        return imageZoomFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final File file = (File) getArguments().getSerializable(ARG_ZOOM);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_zoom, null);

        mImageZoom = (ImageView) v.findViewById(R.id.image_zoom);
        ViewTreeObserver observer = mImageZoom.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Bitmap bitmap = PictureUtils.getScaledBitmap(file.getPath(), mImageZoom.getMeasuredWidth(), mImageZoom.getMeasuredHeight());
                mImageZoom.setImageBitmap(bitmap);
            }
        });

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.zomm_image_title)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        sendResult(Activity.RESULT_OK);
                    }
                })
                .create();
    }

    private void sendResult(int resultCode) {
        if (getTargetFragment() == null) {
            return;
        }

        Intent intent = new Intent();

        getTargetFragment()
                .onActivityResult(getTargetRequestCode(), resultCode, intent);
    }
}
