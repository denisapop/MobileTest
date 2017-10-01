package com.popescu.mobiletest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by atnm-4 on 29/09/2017.
 */

public class Users {
    @Expose
    @SerializedName("results")
    private ArrayList<User> user;

    public static ArrayList<User> sUsers;

    public ArrayList<User> getUser() {
        return user;
    }

    public void setUser(ArrayList<User> user) {
        this.user = user;
    }

    public static ArrayList<User> getsUsers() {
        return sUsers;
    }

    public static void setsUsers(ArrayList<User> sUsers) {
        Users.sUsers = sUsers;
    }

    public class User {
        @Expose
        @SerializedName("name")
        private Name userName;
        @Expose
        @SerializedName("gender")
        private String gender;

        @Expose
        @SerializedName("email")
        private String email;
        @Expose
        @SerializedName("phone")
        private String phone;
        @Expose
        @SerializedName("cell")
        private String cell;
        @Expose
        @SerializedName("registered")
        private String registered;
        @Expose
        @SerializedName("nat")
        private String nat;
        @Expose
        @SerializedName("dob")
        private String dob;

        @Expose
        @SerializedName("id")
        private Id id;

        public Id getId() {
            return id;
        }

        public void setId(Id id) {
            this.id = id;
        }

        public String getRegistered() {
            return registered;
        }

        public String getNat() {
            return nat;
        }

        public String getDob() {
            return dob;
        }

        public Name getUserName() {
            return userName;
        }

        public String getGender() {
            return gender;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public String getCell() {
            return cell;
        }

        public Photo getUserPhoto() {
            return userPhoto;
        }

        @Expose
        @SerializedName("location")
        private Location location;

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        @Expose
        @SerializedName("picture")
        private Photo userPhoto;

        public class Name {
            @Expose
            @SerializedName("title")
            private String title;
            @Expose
            @SerializedName("first")
            private String first;
            @Expose
            @SerializedName("last")
            private String last;

            public String getTitle() {
                return title;
            }

            public String getFirst() {
                return first;
            }

            public String getLast() {
                return last;
            }
        }

        public class Photo {
            @Expose
            @SerializedName("large")
            private String large;
            @Expose
            @SerializedName("medium")
            private String medium;
            @Expose
            @SerializedName("thumbnail")
            private String thumbnail;

            public String getLarge() {
                return large;
            }

            public String getMedium() {
                return medium;
            }

            public String getThumbnail() {
                return thumbnail;
            }
        }

        public class Location {
            @Expose
            @SerializedName("street")
            private String street;
            @Expose
            @SerializedName("city")
            private String city;
            @Expose
            @SerializedName("state")
            private String state;
            @Expose
            @SerializedName("postcode")
            private String postcode;

            public String getStreet() {
                return street;
            }

            public String getCity() {
                return city;
            }

            public String getState() {
                return state;
            }

            public String getPostcode() {
                return postcode;
            }
        }


        public class Id {
            @Expose
            @SerializedName("name")
            private String name;
            @Expose
            @SerializedName("value")
            private String value;

            public String getName() {
                return name;
            }

            public String getValue() {
                return value;
            }
        }
    }
}
