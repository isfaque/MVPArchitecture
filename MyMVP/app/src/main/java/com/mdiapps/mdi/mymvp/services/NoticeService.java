package com.mdiapps.mdi.mymvp.services;

import com.mdiapps.mdi.mymvp.R;
import com.mdiapps.mdi.mymvp.views.fragments.notice.NoticeFragment;

/**
 * Created by Mascot on 2/7/2017.
 */
public class NoticeService {
    public boolean notice(String[] noticelist_date, String[] noticelist_title, String[] noticelist_detail) {

        for(int i=0;i<noticelist_date.length;i++){

            String date = noticelist_date[i];
            String title = noticelist_title[i];
            String detail = noticelist_detail[i];
            NoticeFragment.noticelist_notice_date.add(date);
            NoticeFragment.noticelist_notice_title.add(title);
            NoticeFragment.noticelist_notice_detail.add(detail);
        }
        return true;
    }
}
