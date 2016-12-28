  /**
   * Copyright (C) 2016 Securibox
   * 
   * This program is free software: you can redistribute it and/or modify 
   * it under the terms of the GNU General Public License as published by 
   * the Free Software Foundation, either version 3 of the License, or 
   * (at your option) any later version.
   * 
   * This program is distributed in the hope that it will be useful, 
   * but WITHOUT ANY WARRANTY; without even the implied warranty of 
   * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
   * GNU General Public License for more details.
   * 
   * You should have received a copy of the GNU General Public License 
   * along with this program.  If not, see <http://www.gnu.org/licenses/>.
   */

package core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonSerializer;

import core.exceptions.ClientException;
import core.exceptions.ResponseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface Client.
 */
public interface Client {

	/**
	 * Gets the.
	 *
	 * @param path
	 *            the path
	 * @return the response
	 * @throws ClientException
	 *             the client exception
	 * @throws ResponseException
	 *             the response exception
	 */
	public Response get(String path) throws ClientException, ResponseException;

	/**
	 * Post.
	 *
	 * @param path
	 *            the path
	 * @return the response
	 * @throws ClientException
	 *             the client exception
	 * @throws ResponseException
	 *             the response exception
	 */
	public Response post(String path) throws ClientException, ResponseException;

	/**
	 * Post.
	 *
	 * @param path
	 *            the path
	 * @param payload
	 *            the payload
	 * @return the response
	 * @throws ClientException
	 *             the client exception
	 * @throws ResponseException
	 *             the response exception
	 */
	public Response post(String path, String payload) throws ClientException, ResponseException;

	/**
	 * Put.
	 *
	 * @param path
	 *            the path
	 * @return the response
	 * @throws ClientException
	 *             the client exception
	 * @throws ResponseException
	 *             the response exception
	 */
	public Response put(String path) throws ClientException, ResponseException;

	/**
	 * Put.
	 *
	 * @param path
	 *            the path
	 * @param payload
	 *            the payload
	 * @return the response
	 * @throws ClientException
	 *             the client exception
	 * @throws ResponseException
	 *             the response exception
	 */
	public Response put(String path, String payload) throws ClientException, ResponseException;

	/**
	 * Delete.
	 *
	 * @param path
	 *            the path
	 * @return the response
	 * @throws ClientException
	 *             the client exception
	 * @throws ResponseException
	 *             the response exception
	 */
	public Response delete(String path) throws ClientException, ResponseException;

	/**
	 * Serialize.
	 *
	 * @param obj
	 *            the obj
	 * @return the string
	 * @throws ClientException
	 *             the client exception
	 */
	public String serialize(Object obj) throws ClientException;

	/**
	 * Deserialize.
	 *
	 * @param <T>
	 *            the generic type
	 * @param body
	 *            the body
	 * @param typeReference
	 *            the type reference
	 * @return the t
	 * @throws ClientException
	 *             the client exception
	 */
	public <T> T deserialize(String body, TypeReference<T> typeReference) throws ClientException;

	/**
	 * Adds the serializer.
	 *
	 * @param <T>
	 *            the generic type
	 * @param type
	 *            the type
	 * @param ser
	 *            the ser
	 */
	public <T> void addSerializer(Class<? extends T> type, JsonSerializer<T> ser);
}
