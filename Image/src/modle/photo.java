package modle;
import android.os.Parcel;
import android.os.Parcelable;
public class photo implements Parcelable
{
	private String name;
    private int image;

    public photo() 
    {
    }

    public photo(String name, int image) 
    {
        this.name = name;
        this.image = image;
    }

    protected photo(Parcel in)
    {
    	image=in.readInt();
    	name=in.readString();
    }
    public static final Creator<photo> CREATOR=new  Creator<photo>()
    {
		@Override
		public photo createFromParcel(Parcel in) {
			// TODO Auto-generated method stub
			 return new photo(in);
		}

		@Override
		public photo[] newArray(int size) {
			// TODO Auto-generated method stub
			return new photo[size];
		}
    };	
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getImage() 
    {
        return image;
    }

    public void setImage(int image) 
    {
        this.image = image;
    }

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeInt(image);
		dest.writeString(name);
		
	}
}
