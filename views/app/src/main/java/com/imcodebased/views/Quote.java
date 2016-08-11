package com.imcodebased.views;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by codebased on 11/08/16.
 */
public class Quote implements Parcelable {

    private String quote ;

    public String getQuote(){
        return quote;
    }
    protected Quote(Parcel in) {
        quote = in.readString();
    }

    public Quote(){
        this.quote = "default quote";
    }

    public static final Creator<Quote> CREATOR = new Creator<Quote>() {
        @Override
        public Quote createFromParcel(Parcel in) {
            return new Quote(in);
        }

        @Override
        public Quote[] newArray(int size) {
            return new Quote[size];
        }
    };

    // what is this - http://stackoverflow.com/questions/4076946/parcelable-where-when-is-describecontents-used/4914799#4914799
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(quote);
    }
}
