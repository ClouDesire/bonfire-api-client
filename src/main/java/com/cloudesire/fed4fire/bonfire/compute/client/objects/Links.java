package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class Links
{

	@XmlType
	@XmlAccessorType (value = XmlAccessType.PROPERTY)
	public static class Link
	{
		public Link (){}
		public Link (String href, String rel)
		{
			this.href = href;
			this.rel = rel;
		}

		private String rel;
		private String href;
		private String type;

		@XmlAttribute (name = "rel")
		public String getRel ()
		{
			return rel;
		}

		public void setRel ( String rel )
		{
			this.rel = rel;
		}
		@XmlAttribute(name = "href")
		public String getHref ()
		{
			return href;
		}

		public void setHref ( String href )
		{
			this.href = href;
		}
		@XmlAttribute(name = "type")
		public String getType ()
		{
			return type;
		}

		public void setType ( String type )
		{
			this.type = type;
		}

		@Override public String toString ()
		{
			return "Link{" +
					"rel='" + rel + '\'' +
					", href='" + href + '\'' +
					", type='" + type + '\'' +
					'}';
		}
	}

	private List<Link> links;

	@XmlElement (name="link")
	public List<Link> getLinks ()
	{
		return links;
	}

	public void setLinks ( List<Link> links )
	{
		this.links = links;
	}

	@Override public String toString ()
	{
		return links != null ? links.toString() : "";
	}
}
