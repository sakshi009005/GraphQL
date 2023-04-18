package com.my.graphql.exception;

import java.util.List;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class UnknownOrderTypeException extends Exception implements GraphQLError {

	public UnknownOrderTypeException(String message) {
		 super(message, null, false, false);
	}

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}

	@Override
	public ErrorType getErrorType() {
		return null;
	}

}
