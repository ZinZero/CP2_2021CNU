package kr.ac.cnu.computer.week12test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.*;

// MessageAdapter는 recyclerview와 message사이에서 징검다리 역할
// 호출순서: notifyinserted(position) -> onCreateViewHolder -> onBindViewHolder
public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Message> list;
    /*
        위의 list 변수에는 null이 초기화되어 있으므로 list에 값을 넣어줄 수 있는 생성자나 메소드 정의해야 함
    */

    // 생성자 호출후 인자로 받은 list를 어댑터의 리스트에 추가
    public MessageAdapter(List<Message> list) {
        this.list = list;
    }

    public void add(Message msg) {
        list.add(msg);
    }

    @NonNull
    @Override
    // Message UI를 만들어주는 함수
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (Objects.requireNonNull(MessageType.of(viewType))) {
            case LEFT_CONTENTS:
//                 return new LeftViewHolder(inflater.inflate(R.layout.message_left_item, parent, false));
                return null;
            case RIGHT_CONTENTS:
                return new RightViewHolder(inflater.inflate(R.layout.message_right_item, parent, false));
            default:
//                 return new CenterViewHolder(inflater.inflate(R.layout.message_center_item, parent, false));
                return null;
        }
    }

    // 메세지를 출력해서 실제로 채팅창에 출력을 해주는 코드
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message msg = list.get(position); //notifyinserted msg
        RightViewHolder msgView = (RightViewHolder) holder;
        msgView.datetimeText.setText(msg.getRegisterDate());
        msgView.messageText.setText(msg.getMessage());
    }
    /*
        이 메소드를 구현하시오.
    */
    @Override
    public int getItemCount() {return list.size();}

    // 이 메소드를 재정의 하면 onCreateViewHolder 메소드의 두번째 파라미터 viewType 변수에 이 메소드의 리턴값이 들어간다.
    @Override
    public int getItemViewType(int position) {
        // 해당 메시지의 message_type을 리턴
        return list.get(position).getMessageType().getCode();
    }

    private class RightViewHolder extends RecyclerView.ViewHolder { // MesssageUI
        private final TextView messageText; // 채팅 내용 UI
        private final TextView datetimeText; // 날짜 채용 UI

        public RightViewHolder(@NonNull View itemView) {
            super(itemView);
            messageText = itemView.findViewById(R.id.messageText);
            datetimeText = itemView.findViewById(R.id.datetimeText);
        }
    }
}
