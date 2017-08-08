package com.layer.ui.identity;

import com.layer.sdk.messaging.Identity;
import com.layer.ui.fourpartitem.FourPartItemViewModel;
import com.layer.ui.recyclerview.OnItemClickListener;
import com.layer.ui.util.DateFormatter;

import java.util.HashSet;
import java.util.Set;

public class IdentityItemViewModel extends FourPartItemViewModel<Identity> {

    protected IdentityFormatter mIdentityFormatter;
    protected DateFormatter mDateFormatter;

    public IdentityItemViewModel(OnItemClickListener<Identity> onItemClickListener,
                                 IdentityFormatter identityFormatter, DateFormatter dateFormatter) {
        super(onItemClickListener);
        mIdentityFormatter = identityFormatter;
        mDateFormatter = dateFormatter;
    }

    @Override
    public void setItem(Identity identity) {
        super.setItem(identity);
        notifyChange();
    }

    @Override
    public String getTitle() {
        return mIdentityFormatter.getDisplayName(getItem());
    }

    @Override
    public String getSubtitle() {
        return mIdentityFormatter.getMetaData(getItem());
    }

    @Override
    public String getAccessoryText() {
        return mDateFormatter.formatTimeDay(getItem().getLastSeenAt());
    }

    @Override
    public boolean isSecondaryState() {
        return false;
    }

    @Override
    public Set<Identity> getIdentities() {
        Set<Identity> identities = new HashSet<>(1);
        identities.add(getItem());

        return identities;
    }
}
