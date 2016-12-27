package com.muinv.selfplan.view.fragment;

import android.support.v4.app.Fragment;
import android.widget.Toast;
import com.muinv.selfplan.di.HasComponent;

/**
 * Created by FRAMGIA\nguyen.van.mui on 27/12/2016.
 */

public class BaseSupportFragment extends Fragment {
    /**
     * Shows a {@link android.widget.Toast} message.
     *
     * @param message An string representing a message to be shown.
     */
    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
