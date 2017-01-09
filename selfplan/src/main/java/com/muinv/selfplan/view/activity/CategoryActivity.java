package com.muinv.selfplan.view.activity;

import android.content.Context;
import android.content.Intent;

/**
 * Created by FRAMGIA\nguyen.van.mui on 09/01/2017.
 */

public class CategoryActivity extends BaseActivity {
    public static Intent getCallingIntent(Context context) {
        return new Intent(context, UserListActivity.class);
    }


}
