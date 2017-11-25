package com.zhaoci.framework.taglib;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * 标签页面响应转换器
 */
public class TagPageResponseWrapper extends HttpServletResponseWrapper {
	private ByteArrayOutputStream outputStream;
	private TagPagePrintWriter tagPagePrintWriter;

	public TagPageResponseWrapper(HttpServletResponse response) {
		super(response);
		outputStream = new ByteArrayOutputStream();
		tagPagePrintWriter = new TagPagePrintWriter(outputStream);
	}

	/**
	 * 获取JSP响应的内容
	 * 
	 * @return String JSP响应的内容
	 */
	public String getContent() {
		String content = "";
		tagPagePrintWriter.flush();
		content = tagPagePrintWriter.getByteArrayOutputStream().toString();
		return content;
	}

	/**
	 * 释放资源
	 */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		outputStream.close();
		tagPagePrintWriter.close();
	}

	/**
	 * 覆盖getWriter()方法，使用标签页面PrintWriter
	 */
	@Override
	public PrintWriter getWriter() throws IOException {
		return tagPagePrintWriter;
	}

	/**
	 * 标签页面PrintWriter 注：目的是把response流写到自己指定的输入流当中，而非默认的ServletOutputStream
	 */
	private static class TagPagePrintWriter extends PrintWriter {
		private ByteArrayOutputStream outputStream;

		public TagPagePrintWriter(OutputStream out) {
			super(out);
			outputStream = (ByteArrayOutputStream) out;
		}

		public ByteArrayOutputStream getByteArrayOutputStream() {
			return outputStream;
		}
	}
}
