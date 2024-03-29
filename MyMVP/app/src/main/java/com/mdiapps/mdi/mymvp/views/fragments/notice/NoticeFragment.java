package com.mdiapps.mdi.mymvp.views.fragments.notice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.mdiapps.mdi.mymvp.R;
import com.mdiapps.mdi.mymvp.helpers.CustomAdapter.NoticeAdapter;
import com.mdiapps.mdi.mymvp.presenters.HomePresenter;
import com.mdiapps.mdi.mymvp.presenters.NoticePresenter;
import com.mdiapps.mdi.mymvp.services.HomeService;
import com.mdiapps.mdi.mymvp.services.NoticeService;
import com.mdiapps.mdi.mymvp.views.fragments.contact.ContactFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mascot on 2/7/2017.
 */
public class NoticeFragment extends Fragment implements NoticeView {

    ListView list;
    private AlertDialog alertbox;

    private NoticePresenter presenter;

    public static List<String> noticelist_notice_date = new ArrayList<String>();
    public static List<String> noticelist_notice_title = new ArrayList<String>();
    public static List<String> noticelist_notice_detail = new ArrayList<String>();

    public static String user_notice_date, user_notice_title, user_notice_detail;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notice, container, false);

        noticelist_notice_date.clear();
        noticelist_notice_title.clear();
        noticelist_notice_detail.clear();

        list=(ListView) v.findViewById(R.id.list);

        presenter = new NoticePresenter(this, new NoticeService());

        String[] noticelist_date = getResources().getStringArray(R.array.noticelist_date);
        String[] noticelist_title = getResources().getStringArray(R.array.noticelist_title);
        String[] noticelist_detail = getResources().getStringArray(R.array.noticelist_detail);


        presenter.getNotice(noticelist_date, noticelist_title, noticelist_detail);

        return v;
    }

    @Override
    public void startGetNotice() {
        NoticeAdapter adapter=new NoticeAdapter(getActivity(), noticelist_notice_date, noticelist_notice_title, noticelist_notice_detail);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem1= noticelist_notice_date.get(position);


                user_notice_date = noticelist_notice_date.get(position);
                user_notice_title = noticelist_notice_title.get(position);
                user_notice_detail = noticelist_notice_detail.get(position);

                Toast.makeText(getActivity(),Slecteditem1,Toast.LENGTH_SHORT).show();





            }
        });
    }

}
