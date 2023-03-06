package org.opengraph;

import io.github.wechaty.Wechaty;
import io.github.wechaty.user.Room;
import io.github.wechaty.utils.QrcodeUtils;
import org.apache.commons.lang3.StringUtils;

public class BootStrap {
    Wechaty bot = Wechaty.instance("your_token")
        .onScan((qrcode, statusScanStatus, data) -> System.out.println(QrcodeUtils.getQr(qrcode)))
        .onLogin(user -> System.out.println(user))
        .onMessage(message -> {
            Room room = message.room();
            String text = message.text();
            if (StringUtils.equals(text, "#ding")) {
                if (room != null) {
                    room.say("dong");
                }
            }
        }).start(true);
}
