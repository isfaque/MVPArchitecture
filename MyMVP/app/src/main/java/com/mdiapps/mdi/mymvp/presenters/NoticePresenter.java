package com.mdiapps.mdi.mymvp.presenters;

import com.mdiapps.mdi.mymvp.R;
import com.mdiapps.mdi.mymvp.services.HomeService;
import com.mdiapps.mdi.mymvp.services.NoticeService;
import com.mdiapps.mdi.mymvp.views.fragments.home.HomeView;
import com.mdiapps.mdi.mymvp.views.fragments.notice.NoticeView;

/**
 * Created by Mascot on 2/7/2017.
 */
public class NoticePresenter {
    private NoticeView view;
    private NoticeService service;

    public NoticePresenter(NoticeView view, NoticeService service) {
        this.view = view;
        this.service = service;
    }

    public void getNotice(String[] noticelist_date, String[] noticelist_title, String[] noticelist_detail) {
        boolean noticeSucceeded = service.notice(noticelist_date, noticelist_title, noticelist_detail);
        if (noticeSucceeded) {
            view.startGetNotice();
            return;
        }
    }
}
