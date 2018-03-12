package com.example.record_core.activity.delegate;

/**
 * Function :
 * Modify Date : 2018/3/12
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public abstract class RecordDelegate extends PermissionCheckDelegate {

    public <T extends RecordDelegate>T getParentDelegate(){
        return (T) getParentFragment();
    }
}
