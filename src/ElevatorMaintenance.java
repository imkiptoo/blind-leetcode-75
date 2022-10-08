import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Version {
	public int major;
	public int minor;
	public int revision;
	public int type;
	public int length;

	Version(int major, int minor, int revision, int type, int length) {
		this.major = major;
		this.minor = minor;
		this.revision = revision;
		this.length = length;
		this.type = type;
	};

	@Override
    public String toString() {
    	if (type == 3)
        	return String.format("%d.%d.%d", major, minor, revision);
        else if (type ==2)
        	return String.format("%d.%d", major, minor);
        else if (type ==1)
        	return String.format("%d", major);
        else
        	return null;
    }
}

class VersionComparator implements Comparator<Version> {
    @Override
    public int compare(Version first, Version second) {
    	if (first.major > second.major) {
			return 1;
		} else if (first.major < second.major) {
			return -1;
		} else {
    		if (first.minor < second.minor) {
				return -1;
			} else if (first.minor > second.minor) {
				return 1;
			} else {
    			if (first.revision > second.revision) {
					return 1;
				} else if (first.revision < second.revision) {
					return -1;
				} else {
    				if (first.length < second.length) {
						return -1;
					} else if (first.length > second.length) {
						return 1;
					} else {
						return 0;
					}
    			}
    		}
    	}
    }
}

public class ElevatorMaintenance {
	public static String[] Solution(String[] l) {
		ArrayList<Version> v = new ArrayList<>();

		for (int i = 0; i < l.length; i++) {
			String a = l[i];
			Version aa = new Version(0, 0, 0, 0, a.length());

			if (a.indexOf(".") > 0) {
				aa.major = Integer.parseInt(a.substring(0, a.indexOf(".")));
				a = a.substring(a.indexOf(".") + 1);

				if (a != "") {
					aa.type = 2;
				}

				if (a.indexOf(".") > 0) {
					aa.minor = Integer.parseInt(a.substring(0, a.indexOf(".")));
					a = a.substring(a.indexOf(".") + 1);
					if (a != "") {
						aa.type = 3;
					}
					aa.revision = Integer.parseInt(a);
				} else {
					aa.minor = Integer.parseInt(a);
				}
			} else {
				aa.major = Integer.parseInt(a);
				aa.type = 1;
			}
			v.add(aa);
		}

		Collections.sort(v, new VersionComparator());

		String[] answer = new String[l.length];
		for (int i = 0; i < l.length; i++) {
			answer[i] = v.get(i).toString();
		}

		return answer;

	}

	public static void main(String[] args) {
		String[] ordered = Solution(new String[]{"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"});
		for (String s : ordered) {
			System.out.print(s+",");
		}
	}
}
