package com.example.practice_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentFirst : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, //xml을 화면에 사용할 준비를 한다 (XML ->  View로 만들어 준다)
        container: ViewGroup?, // 프래그먼트에서 사용될 XML의 부모뷰
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.first_fragment, container, false) // 컨테이너의 자식뷰로서 xml을 넣어준다.
        //attachToRoot: 루트뷰에 붙일지 말지 (x)
    }
}