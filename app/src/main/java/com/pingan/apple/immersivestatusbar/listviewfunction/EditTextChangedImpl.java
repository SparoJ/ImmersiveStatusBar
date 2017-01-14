package com.pingan.apple.immersivestatusbar.listviewfunction;

import android.widget.EditText;

/**
 * @author apple
 * @Description :
 * @date 17/1/14  上午11:43
 */

public interface EditTextChangedImpl {
    void getEditTextMsg(ListEditTextBean editTextBean);

    void  getChangedEditText(EditText  edit, int position);
}
