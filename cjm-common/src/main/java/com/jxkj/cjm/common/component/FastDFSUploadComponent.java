package com.jxkj.cjm.common.component;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.DefaultFastFileStorageClient;
import com.jxkj.cjm.common.util.WaterMarkUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 
* @ClassName: FastDFSUploadComponent 
* @Description: TODO(fdfs 文件上传工具类) 
* @author cjm
* @date 2018年5月9日 上午9:56:46 
*
 */
@Component
public class FastDFSUploadComponent {
	
	//文件上传处理状态码&&返回描述
	public static final String FDFS_STATE ="state";//文件上传状态
	public static final String FDFS_MSG ="msg";//文件上传状态描述
	public static final String FDFS_SUCCESS_STATUS ="SUCCESS";//成功
	public static final String FDFS_FAIL_STATUS ="FAIL";//失败
  	public static final String FDFS_URL ="url";  //图片or文件路径

	//图片上传返回
	public static final String FDFS_THUMBURL ="thumburl";//图片缩略图路径
	public static final String FDFS_TITLE ="title";//图片原始名称
	public static final String FDFS_ORIGINAL ="original";//图片原始名称
	public static final String FDFS_WATERMARKURL ="watermarkurl";//水印图片路径
	
	//图片加水印
 	private static final String FDFS_WATERMARK_LOGOIMG_PATH = "src/main/resources/watermark.png";//水印图片路径
	private static final String FDFS_TEMP_PATH = "watermarktemp";//临时文件目录
 	  
	@Resource
	private DefaultFastFileStorageClient defaultFastFileStorageClient; 
  
	@Resource
    private ThumbImageConfig thumbImageConfig;
	
	@Value("${cjm.fdfs.host}")
	private String hostUrl; //application.properties  配置的图片服务器域名
	
	/**
	 * 
	* @Title: uploadImageAndCrtThumbImage 
	* @Description: TODO(上传原图片&&缩略图) 
	* @param @param multipartFile
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws
	 */
	public Map<String,Object> uploadImageAndCrtThumbImage(MultipartFile multipartFile){
		Map<String,Object> res = new HashMap<>();
		res.put(FDFS_STATE, FDFS_FAIL_STATUS);
		res.put(FDFS_MSG, "图片上传失败");
  		try{
  	    
 			String originalFilename = multipartFile.getOriginalFilename();
   			StorePath storePath =  defaultFastFileStorageClient.uploadImageAndCrtThumbImage(multipartFile.getInputStream(), 
					multipartFile.getSize(), FilenameUtils.getExtension(multipartFile.getOriginalFilename()), null);
			if(storePath != null){
  				//缩略图路径
				String thumburl = thumbImageConfig.getThumbImagePath(storePath.getFullPath());
				String url = storePath.getFullPath();
				res.put(FDFS_URL, url);
				res.put(FDFS_STATE, FDFS_SUCCESS_STATUS);
				res.put(FDFS_TITLE, originalFilename);
				res.put(FDFS_ORIGINAL, originalFilename);
				res.put(FDFS_THUMBURL, thumburl);
  				return res;
			}
			return res;
		}catch(Exception e){
			e.printStackTrace();
			return res;
		}
	}
	
	/**
	 * 
	* @Title: uploadImageAndCrtThumbImage 
	* @Description: TODO(上传原图片&&缩略图&&水印图) 
	* @param @param multipartFile
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws
	 */
	public Map<String,Object> uploadImageAndCrtThumbAndWaterImage(MultipartFile multipartFile){
		Map<String,Object> res = new HashMap<>();
		res.put(FDFS_STATE, FDFS_FAIL_STATUS);
		res.put(FDFS_MSG, "图片上传失败");
  		try{
  	    
 			String originalFilename = multipartFile.getOriginalFilename();
   			StorePath storePath =  defaultFastFileStorageClient.uploadImageAndCrtThumbImage(multipartFile.getInputStream(), 
					multipartFile.getSize(), FilenameUtils.getExtension(multipartFile.getOriginalFilename()), null);
			if(storePath != null){
  				//缩略图路径
				String thumburl = thumbImageConfig.getThumbImagePath(storePath.getFullPath());
				StorePath waterStorePath = uploadWaterMark(storePath);//上传水印图
 				String url = storePath.getFullPath();
				res.put(FDFS_URL, url);
				res.put(FDFS_STATE, FDFS_SUCCESS_STATUS);
				res.put(FDFS_TITLE, originalFilename);
				res.put(FDFS_ORIGINAL, originalFilename);
				res.put(FDFS_THUMBURL, thumburl);
				res.put(FDFS_WATERMARKURL, waterStorePath.getFullPath());
  				return res;
			}
			return res;
		}catch(Exception e){
			e.printStackTrace();
			return res;
		}
	}
	
	/**
	 * 
	* @Title: uploadWatermarkImage 
	* @Description: TODO(上传水印图片) 
	* @param @param multipartFile
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws
	 */
	public Map<String,Object> uploadWatermarkImage(StorePath storePath){
		Map<String,Object> res = new HashMap<>();
		res.put(FDFS_STATE, FDFS_FAIL_STATUS);
		res.put(FDFS_MSG, "水印图片上传失败");
		StorePath waterStorePath = uploadWaterMark(storePath);
		if(waterStorePath != null){
 			res.put(FDFS_URL, storePath.getFullPath());//原图路径
			res.put(FDFS_STATE, FDFS_SUCCESS_STATUS);
			res.put(FDFS_WATERMARKURL, waterStorePath.getFullPath());//水印图路径
			res.put(FDFS_MSG, "水印图片上传成功");
			return res;
		}
   		return res;
	}
	
	/**
	 * 
	* @Title: uploadWaterMark 
	* @Description: TODO(水印图片上传) 
	* @param @param storePath
	* @param @return    设定文件 
	* @return StorePath    返回类型 
	* @throws
	 */
	private StorePath uploadWaterMark(StorePath storePath){
 		if(storePath == null){
			throw new IllegalArgumentException("水印图片上传 'StorePath' 不能为空");
		}
		
		try{
 			//获取原图路径
//			String srcImgURL = "http://image.wangdaibus.com/group1/M00/00/00/i8QHkFryrS2AfCTLAD8NwfEa8gU441.png";
 			String srcImgURL = this.hostUrl + storePath.getFullPath();
 			//获取网络图片
			URL url = new URL(srcImgURL);  
	        //打开链接  
	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
 	        //通过输入流获取图片数据  
	        InputStream inStream = conn.getInputStream(); 
 			String srcImgName = storePath.getPath().substring(storePath.getPath().lastIndexOf("/")+1);
			//加水印后保存的图片地址
			String targerPath = getTempFilePath() + System.getProperty("file.separator") + "WaterMark_"+srcImgName;
			String srcImgPath = getTempFilePath() + System.getProperty("file.separator") + srcImgName;
			File targerFile = new File(srcImgPath);
 			FileUtils.copyInputStreamToFile(inStream, targerFile);
			//图片加水印
		    WaterMarkUtils.markImageAutoByIcon(FDFS_WATERMARK_LOGOIMG_PATH, srcImgPath, targerPath, null);
 			 
			File WaterFileExtName = new File(targerPath);
			FileInputStream fileInputStream = null;
			StorePath waterStorePath = null;
			try {
				fileInputStream = FileUtils.openInputStream(WaterFileExtName);
 				//水印图片上传
				waterStorePath = defaultFastFileStorageClient.uploadFile(fileInputStream, WaterFileExtName.length(), FilenameUtils.getExtension(WaterFileExtName.getName()), null);
 				if(waterStorePath != null){
  					return waterStorePath;
 				}
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}finally {
				
				if(fileInputStream != null){
					fileInputStream.close();
				}
				
				if(inStream != null){
					inStream.close();
				}
 			}
			
  		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	 
	//获取系统临时目录
	private File getTempFilePath(){
		File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") +  FDFS_TEMP_PATH  + System.getProperty("file.separator"));
		if(!tmpFile.exists()){
			tmpFile.mkdir();
		}
		return tmpFile;
	}
 	
	// 封装图片完整URL地址
    public String getResAccessUrl(StorePath storePath) {
        String fileUrl = this.hostUrl+storePath.getFullPath();
        System.out.println(fileUrl);
        return fileUrl;
    }
    
     // 封装图片完整URL地址
    public String getResAccessUrl(String storePath) {
        String fileUrl = this.hostUrl+storePath;
        return fileUrl;
    }
	
    
    
}
