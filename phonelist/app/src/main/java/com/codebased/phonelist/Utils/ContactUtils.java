package com.codebased.phonelist.utils;


import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;

import com.codebased.phonelist.widgets.models.ListItemData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ContactUtils {

    private static final String[] PHOTO_ID_PROJECTION = new String[]{
            ContactsContract.Contacts.PHOTO_ID
    };

    private static final String[] PHOTO_BITMAP_PROJECTION = new String[]{
            ContactsContract.CommonDataKinds.Photo.PHOTO
    };


    public static List<ListItemData> getPhoneContacts(Context context) {
        return getPhoneContacts(context, null);
    }

    private static String getPhoneType(int phoneType) {
        String sType = "";
        switch (phoneType) {
            case ContactsContract.CommonDataKinds.Phone.TYPE_HOME:
                sType = "Home";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE:
                sType = "Mobile";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_WORK:
                sType = "Work";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_FAX_HOME:
                sType = "Home Fax";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_FAX_WORK:
                sType = "Work Fax";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_MAIN:
                sType = "Main";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_OTHER:
                sType = "Other";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_CUSTOM:
                sType = "Custom";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_PAGER:
                sType = "Pager";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_ASSISTANT:
                sType = "Assistant";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_CALLBACK:
                sType = "Callback";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_CAR:
                sType = "Car";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_COMPANY_MAIN:
                sType = "Company Main";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_ISDN:
                sType = "ISDN";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_MMS:
                sType = "MMS";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_OTHER_FAX:
                sType = "Other Fax";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_RADIO:
                sType = "Radio";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_TELEX:
                sType = "Telex";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_TTY_TDD:
                sType = "TTY TDD";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_WORK_MOBILE:
                sType = "Work Mobile";
                break;
            case ContactsContract.CommonDataKinds.Phone.TYPE_WORK_PAGER:
                sType = "Work Pager";
                break;
        }

        return sType;
    }

    private Integer fetchThumbnailId(Context context, String phoneNumber) {

        final Uri uri = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Phone.CONTENT_FILTER_URI, Uri.encode(phoneNumber));
        final Cursor cursor = context.getContentResolver().query(uri, PHOTO_ID_PROJECTION, null, null, ContactsContract.Contacts.DISPLAY_NAME + " ASC");

        try {
            Integer thumbnailId = null;
            if (cursor.moveToFirst()) {
                thumbnailId = cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts.PHOTO_ID));
            }
            return thumbnailId;
        } finally {
            cursor.close();
        }

    }

    final Bitmap fetchThumbnail(Context context, final int thumbnailId) {

        final Uri uri = ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, thumbnailId);
        final Cursor cursor = context.getContentResolver().query(uri, PHOTO_BITMAP_PROJECTION, null, null, null);

        try {
            Bitmap thumbnail = null;
            if (cursor.moveToFirst()) {
                final byte[] thumbnailBytes = cursor.getBlob(0);
                if (thumbnailBytes != null) {
                    thumbnail = BitmapFactory.decodeByteArray(thumbnailBytes, 0, thumbnailBytes.length);
                }
            }
            return thumbnail;
        } finally {
            cursor.close();
        }
    }

    public static ListItemData getContact(Context context, String contactID) {

        ListItemData item = null;
        Cursor cursor = context.getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                ContactsContract.CommonDataKinds.Phone._ID + " = ?  ", new String[]{contactID},
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");

        if (cursor.moveToNext()) {
            item = new ListItemData();
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            String id = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));

            item.setId(id);
            item.setText(name);
            item.setSubtext(number);

            int phoneType = cursor.getInt(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));
            item.setRightText(getPhoneType(phoneType));
            item.setPhotoUri(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI)));
            if (item.getPhotoUri() != null && item.getPhotoUri().length() > 0) {
                try {
                    item.setThumbnail(MediaStore.Images.Media.getBitmap(context.getContentResolver(),
                            Uri.parse(item.getPhotoUri())));
                } catch (IOException ignored) {

                }
            }
        }

        cursor.close();

        return item;
    }

    public static List<ListItemData> getPhoneContacts(Context context, ArrayList<String> filteredContacts) {

        Cursor phones = context.getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");

        ArrayList<ListItemData> contactList = new ArrayList<>(phones.getCount());


        while (phones.moveToNext()) {
            String hasPhone = phones.getString(phones.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

            String id = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));

            if (hasPhone.equalsIgnoreCase("1") && (filteredContacts == null || hasContacts(filteredContacts, id))) {
                String name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                if (name != null && name.length() > 0 && number != null && number.length() > 0) {
                    ListItemData contactItem = new ListItemData();
                    contactItem.setId(id);
                    contactItem.setText(name);
                    contactItem.setSubtext(number);
                    int phoneType = phones.getInt(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));
                    contactItem.setRightText(getPhoneType(phoneType));
                    contactItem.setPhotoUri(phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI)));
                    if (contactItem.getPhotoUri() != null && contactItem.getPhotoUri().length() > 0) {
                        try {
                            contactItem.setThumbnail(MediaStore.Images.Media.getBitmap(context.getContentResolver(),
                                    Uri.parse(contactItem.getPhotoUri())));
                        } catch (IOException ignored) {

                        }
                    }

                    contactList.add(contactItem);
                }
            }
        }

        phones.close();


        Map<String, ListItemData> cleanMap = new LinkedHashMap<>();
        for (int i = 0; i < contactList.size(); i++) {
            cleanMap.put(contactList.get(i).getSubtext(), contactList.get(i));
        }

        contactList = new ArrayList<>(cleanMap.values());

        return contactList;

    }

    private static boolean hasContacts(ArrayList<String> filteredContacts, String id) {
        if (filteredContacts == null || filteredContacts.size() == 0) return false;
        for (String c :
                filteredContacts) {
            if (c.equalsIgnoreCase(id)) return true;
        }

        return false;
    }

}