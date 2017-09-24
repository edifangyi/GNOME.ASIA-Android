package com.gnomeasia.bean;

import java.util.List;

/**
 * Created by FANGYI on 2017/9/22.
 */

public class EventBean {


    /**
     * time : 2017-10-14
     * list : [{"room":"305","list":[{"titile":"GNOME.Asia summit Video + show","speark":"gnome","startime":"9:00","endtime":"9:10"},{"titile":"Greeting","speark":"GNOME/重慶大學/鑽石","startime":"9:10","endtime":"9:40"},{"titile":"Greeting","speark":"重慶組委會","startime":"9:40","endtime":"9:55"},{"titile":"Break","speark":"NULL","startime":"10:55","endtime":"11:05"},{"titile":"Keynote","speark":"鑽石預留×2（each 30 mins）","startime":"11:05","endtime":"12:05"},{"titile":"Group Photo Day 1","speark":"NULL","startime":"12:05","endtime":"12:15"},{"titile":"Lunch","speark":"NULL","startime":"12:15","endtime":"13:40"},{"titile":"Flatpak - apps for your desktop","speark":"Matthias Clasen","startime":"13:40","endtime":"14:25"},{"titile":"GNOME and BlockChains - Increasing participation and accountability in decision making","speark":"Anish Patil, Daniel playfair","startime":"14:25","endtime":"15:10"},{"titile":"Tea Break","speark":"NULL","startime":"15:10","endtime":"15:40"},{"titile":"Building A Real Market for Applications","speark":"Sriram Ramkrishna","startime":"15:40","endtime":"16:25"},{"titile":"Break","speark":"NULL","startime":"16:25","endtime":"16:40"},{"titile":"Lighting Talks (8 talks 5min)","speark":"8 talkers","startime":"16:40","endtime":"17:20"},{"titile":"First Day Close","speark":"NULL","startime":"17:20","endtime":"17:30"}]},{"room":"504","list":[{"titile":"GNOME.Asia summit Video + show","speark":"gnome","startime":"9:00","endtime":"9:10"},{"titile":"Greeting","speark":"GNOME/重慶大學/鑽石","startime":"9:10","endtime":"9:40"},{"titile":"Greeting","speark":"重慶組委會","startime":"9:40","endtime":"9:55"},{"titile":"Break","speark":"NULL","startime":"10:55","endtime":"11:05"},{"titile":"Keynote","speark":"鑽石預留×2（each 30 mins）","startime":"11:05","endtime":"12:05"},{"titile":"Group Photo Day 1","speark":"NULL","startime":"12:05","endtime":"12:15"},{"titile":"Lunch","speark":"NULL","startime":"12:15","endtime":"13:40"},{"titile":"Let the general public embrace opensource by being makers","speark":"吳念祖（WU,NIEN-TSU）","startime":"13:40","endtime":"14:25"},{"titile":"Build, Ship and Run -- 让操作系统的定制分发更加简单","speark":"梁辰晔","startime":"14:25","endtime":"15:10"},{"titile":"Tea Break","speark":"NULL","startime":"15:10","endtime":"15:40"},{"titile":"Building medical devices from GNOME","speark":"Ekaterina","startime":"15:40","endtime":"16:25"},{"titile":"Break","speark":"NULL","startime":"16:25","endtime":"16:40"},{"titile":"Lighting Talks (8 talks 5min)","speark":"8 talkers","startime":"16:40","endtime":"17:20"},{"titile":"First Day Close","speark":"NULL","startime":"17:20","endtime":"17:30"}]},{"room":"505","list":[{"titile":"GNOME.Asia summit Video + show","speark":"gnome","startime":"9:00","endtime":"9:10"},{"titile":"Greeting","speark":"GNOME/重慶大學/鑽石","startime":"9:10","endtime":"9:40"},{"titile":"Greeting","speark":"重慶組委會","startime":"9:40","endtime":"9:55"},{"titile":"Break","speark":"NULL","startime":"10:55","endtime":"11:05"},{"titile":"Keynote","speark":"鑽石預留×2（each 30 mins）","startime":"11:05","endtime":"12:05"},{"titile":"Group Photo Day 1","speark":"NULL","startime":"12:05","endtime":"12:15"},{"titile":"Lunch","speark":"NULL","startime":"12:15","endtime":"13:40"},{"titile":"Flatpak - apps for your desktop","speark":"Matthias Clasen","startime":"13:40","endtime":"14:25"},{"titile":"Have fun with OpenQA - OpenQA for GUI testing","speark":"Jiawei Sun / 孙嘉伟","startime":"14:25","endtime":"15:10"},{"titile":"Tea Break","speark":"NULL","startime":"15:10","endtime":"15:40"},{"titile":"open Source is an option of life","speark":"Yan Sun","startime":"15:40","endtime":"16:25"},{"titile":"Break","speark":"NULL","startime":"16:25","endtime":"16:40"},{"titile":"Lighting Talks (8 talks 5min)","speark":"8 talkers","startime":"16:40","endtime":"17:20"},{"titile":"First Day Close","speark":"NULL","startime":"17:20","endtime":"17:30"}]}]
     */

    private String time;
    private List<ListRoom> list;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<ListRoom> getList() {
        return list;
    }

    public void setList(List<ListRoom> list) {
        this.list = list;
    }

    public static class ListRoom {
        /**
         * room : 305
         * list : [{"titile":"GNOME.Asia summit Video + show","speark":"gnome","startime":"9:00","endtime":"9:10"},{"titile":"Greeting","speark":"GNOME/重慶大學/鑽石","startime":"9:10","endtime":"9:40"},{"titile":"Greeting","speark":"重慶組委會","startime":"9:40","endtime":"9:55"},{"titile":"Break","speark":"NULL","startime":"10:55","endtime":"11:05"},{"titile":"Keynote","speark":"鑽石預留×2（each 30 mins）","startime":"11:05","endtime":"12:05"},{"titile":"Group Photo Day 1","speark":"NULL","startime":"12:05","endtime":"12:15"},{"titile":"Lunch","speark":"NULL","startime":"12:15","endtime":"13:40"},{"titile":"Flatpak - apps for your desktop","speark":"Matthias Clasen","startime":"13:40","endtime":"14:25"},{"titile":"GNOME and BlockChains - Increasing participation and accountability in decision making","speark":"Anish Patil, Daniel playfair","startime":"14:25","endtime":"15:10"},{"titile":"Tea Break","speark":"NULL","startime":"15:10","endtime":"15:40"},{"titile":"Building A Real Market for Applications","speark":"Sriram Ramkrishna","startime":"15:40","endtime":"16:25"},{"titile":"Break","speark":"NULL","startime":"16:25","endtime":"16:40"},{"titile":"Lighting Talks (8 talks 5min)","speark":"8 talkers","startime":"16:40","endtime":"17:20"},{"titile":"First Day Close","speark":"NULL","startime":"17:20","endtime":"17:30"}]
         */

        private String room;
        private List<ListSpeark> list;

        public String getRoom() {
            return room;
        }

        public void setRoom(String room) {
            this.room = room;
        }

        public List<ListSpeark> getList() {
            return list;
        }

        public void setList(List<ListSpeark> list) {
            this.list = list;
        }

        public static class ListSpeark {
            /**
             * titile : GNOME.Asia summit Video + show
             * speark : gnome
             * startime : 9:00
             * endtime : 9:10
             */

            private String titile;
            private String speark;
            private String startime;
            private String endtime;

            public String getTitile() {
                return titile;
            }

            public void setTitile(String titile) {
                this.titile = titile;
            }

            public String getSpeark() {
                return speark;
            }

            public void setSpeark(String speark) {
                this.speark = speark;
            }

            public String getStartime() {
                return startime;
            }

            public void setStartime(String startime) {
                this.startime = startime;
            }

            public String getEndtime() {
                return endtime;
            }

            public void setEndtime(String endtime) {
                this.endtime = endtime;
            }
        }
    }
}
