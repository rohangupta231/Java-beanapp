import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class EmpServices
{
	private static ArrayList<EmpBean> al;//Data Layer
	static
	{
		al=new ArrayList<EmpBean>();
	}
	public static boolean addEmployee(EmpBean objbean)
	{
		if(searchById(objbean.getEmpId())==null)
		{
			al.add(objbean);
			return true;
		}
		return false;	
	}
	public static List getAllEmployees()
	{
		/*List is Interface for array list so can have its object*/
		List temp= Collections.unmodifiableList(al);//unmodifilable list
		return temp;
	}
	public static EmpBean searchById(int id)
	{
		for(int i=0;i<al.size();i++)
		{
			EmpBean objbean=al.get(i);
			if(id==(objbean.getEmpId()))
			{
				return objbean;
			}
		}
		return null;
	}
	public static boolean deleteById(int id)
	{
		EmpBean objbean=searchById(id);
		if(objbean!=null)
		{
			al.remove(objbean);
			return true;
		}
		return false;
	}
}